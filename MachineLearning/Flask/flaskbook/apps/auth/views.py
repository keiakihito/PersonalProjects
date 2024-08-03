from apps.app import db
from apps.auth.forms import SignUpForm
from apps.crud.models import User
from flask import Blueprint, render_template, flash, url_for, redirect, request
from flask_login import login_user



#Instantiate auth with Blueprint
auth = Blueprint(
    "auth",
    __name__,
    template_folder="templates",
    static_folder = "static"
)

#Create index endpoint
@auth.route("/")
def index():
    return render_template("auth/index.html")

@auth.route("/signup", methods=["GET", "POST"])
def signup():
    #Instantiate SignUpForm
    form = SignUpForm()
    if form.validate_on_submit():
        user = User(
            username = form.username.data,
            email = form.email.data,
            password = form.password.data,
        )

        #Check duplicated mail address
        if user.is_duplicate_email():
            flash("The email address has been already registered.")
            return redirect(url_for("auth.signup"))

        #Register user information
        db.session.add(user)
        db.session.commit()

        #Store user info to session
        login_user(user)

        #GET parameter has next key, but no value => Back to user page
        next_ = request.args.get("next")
        if next_ is None or not next_.startswith("/"):
            next_ = url_for("crud.users")
        return redirect(next_)

    return render_template("auth/signup.html", form = form)