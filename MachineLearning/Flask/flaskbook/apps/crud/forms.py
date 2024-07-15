from flask_wtf import FlaskForm
from wtforms import PasswordField, StringField, SubmitField
from wtforms.validators import DataRequired, Email, length

#New user and edit user form class
#Inherit FlaskForm
classUserForm(FlaskForm):
    # Set username attribution label and validators for user form
    #StringFiels is for user input
    username = StringField(
        "User Name", #Label for username field
        validators = [
            DataRequired(message = "User Name is required"),
            length(max = 30, message = "Within 30 letters"),
        ],
    )

    #Set user form email attribution and validators
    email = StringField(
        "email address",
        validators = [
            DataRequired(message = "email address is required"),
            Email(message = "Make sure email address format"),
        ],
    )

    #Set password attribution label and validators
    password = PasswordField(
        "Password",
        validators = [DataRequired(message = "Password is required")]
    )

    #set userform submit
    submit = SubmitField("New Register")
