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

@crud.route("users/<user_id>", methods = ["GET", "POST"])
def edit_user(user_id):
    #Instatiate a UserForm object in forms.py
    #It used to collect user input for editing user details.
    form = UserForm()

    # Get user object with User model
    #.first() retrieves the first result of the query, the user matched with the specified id.
    user = User.query.filter_by(id =user_id).first()

    #When the data comes from form, it updates database and redirect all the user list
    #Check if the form has been submitted with a POST request
    #Check the form data is valid according to the validators defined in UserForm.
    if form.validate_on_submit():
        user.username = form.username.data
        user.email = form.email.data
        user.password = form.password.data
        db.session.add(user)
        db.session.commit()
        return redirect(url_for("crud.users"))

    #When the request method is GET, it returns HTML
    return render_template("crud/edit.html", user = user, form = form)

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


@crud.route("/users/<user_id>/delete", methods = ["POST"])
def delete_user(user_id):
    user = User.query.filter_by(id=user_id).first()
    db.session.delete(user)
    db.session.commit()
    return redirect(url_for("crud.users"))


@crud.route("/test-db")
def test_db():
    try:
        #Perform a simple database query
        users = User.query.all()
        return f"successful commected to the database. Found {len(users)} users."

    except Exception as e:
        return f"Error connecting to the database: {str(e)}"
