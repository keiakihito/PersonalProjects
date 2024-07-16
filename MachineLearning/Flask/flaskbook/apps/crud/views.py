from apps.crud.forms import UserForm

#import db
from apps.app import db
#Import User class
from apps.crud.models import User

from flask import Blueprint, render_template, redirect, url_for

# Constructor
# Create crud app instance with Blueprint
crud = Blueprint(
    "crud",
    __name__,
    template_folder = "templates",
    static_folder = "static",
)

# Create index endpoint and return index.html
@crud.route("/")
def index():
    return render_template("crud/index.html")


@crud.route("/sql")
def sql():
    db.session.query(User).all()
    return "Check console"

@crud.route("/users")
def users():
    #Get all the user info
    #Retrieves all records from the users table in the database to fetch user objects
    #Make a list of user objects.
    users = User.query.all()
    return render_template("crud/index.html", users = users)

@crud.route("/users/new", methods = ["GET", "POST"])
def create_user():
    #Instatiate UserForm
    form = UserForm()

    #Validate values in form
    if form.validate_on_submit():
        #Create user
        user = User(
            username = form.username.data,
            email = form.email.data,
            password = form.password.data,
        )

        #Add and commit user
        db.session.add(user)
        db.session.commit()

        #Redirect user overview
        return redirect(url_for("crud.users"))

    #Redner the form template if the form is not valid
    return render_template("crud/create.html", form = form)