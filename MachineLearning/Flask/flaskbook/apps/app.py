from pathlib import Path
from flask import Flask
from flask_migrate import Migrate
from flask_sqlalchemy import SQLAlchemy
from flask_wtf.csrf import CSRFProtect

#Instantiate SQLAlchemy
db = SQLAlchemy()

#Instantiate CSRFProtect
csrf = CSRFProtect()

#Instantiate app with Create_app function
#It makes easier to switch test  and production environment
def create_app():
    #Instantiate Flask app
    app = Flask(__name__)

    #Configure App variables
    # Enable SQLite in SQLAlchemy
    app.config.from_mapping(
        SECRET_KEY = "2AZSMss3p5QPbcY2hBsJ",
        SQLALCHEMY_DATABASE_URI =
            f"sqlite:///{Path(__file__).parent.parent / 'local.sqlite'}",
        SQLALCHEMY_TRACK_MODIFICATIONS = False,
        SQLALCHEMY_ECHO = True,
        WTF_CSRF_SECRET_KEY = "AuwzyszU5sugKN7KZs6f",
    )

    #Connect app and csrf
    csrf.init_app(app)

    #Connect app and SQLAlchemy
    db.init_app(app)

    #Connect app and Migrate
    Migrate(app, db)

    #Import views from crud package
    from apps.crud import views as crud_views

    #Register views in crud (Blueprint object) to app with register_blueprint function
    #Allow all the routes defined in the 'crud' blueprint will stat like crud/~
    app.register_blueprint(crud_views.crud, url_prefix="/crud")

    return app




#Run apps when it is directly called.
if __name__ == "__main__":
    app = create_app()
    app.run(debug = True)

