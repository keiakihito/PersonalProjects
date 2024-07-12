from flask import Blueprint, render_template

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