from flask import Blueprint, render_template

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