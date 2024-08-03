import os
from pathlib import Path
from flask import Flask
from flask_migrate import Migrate
from flask_sqlalchemy import SQLAlchemy
from flask_wtf.csrf import CSRFProtect
from dotenv import load_dotenv
from apps.crud.models import db
from apps.config import config
from flask_login import LoginManager

# Load environment variables from a .env file
load_dotenv()

# Instantiate CSRFProtect
csrf = CSRFProtect()

#Instantiate LoginManager
login_manager = LoginManager()

#Set endpoint to redirect when login_view attribution is non-login
login_manager.login_view = "auth.signup"

#Set a message after login login_message attribution
#Make it empty
login_manager.login_message = ""



# Instantiate app with Create_app function
# It makes easier to switch test and production environment
def create_app(config_key = None):
    # Instantiate Flask app
    app = Flask(__name__)

    #Load corresponding config key
    config_key = config_key or os.getenv('FLASK_CONFIG')
    app.config.from_object(config[config_key])

    # Configure App variables from environment
    DB_USER = os.getenv('DB_USER')
    DB_PASSWORD = os.getenv('DB_PASSWORD')
    DB_HOST = os.getenv('DB_HOST')
    DB_PORT = os.getenv('DB_PORT', 5432)
    DB_NAME = os.getenv('DB_NAME')
    SECRET_KEY = os.getenv('SECRET_KEY')

    app.config['SQLALCHEMY_DATABASE_URI'] = f'postgresql+psycopg2://{DB_USER}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/{DB_NAME}'
    app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
    app.config['SQLALCHEMY_ECHO'] = True
    app.config['SECRET_KEY'] = SECRET_KEY

    # Initialize SQLAlchemy and migrate
    db.init_app(app)
    migrate = Migrate(app, db)

    # Connect app and csrf
    csrf.init_app(app)

    #Connect login_manager with app
    login_manager.init_app(app)

    from apps.crud.models import User # Import here to avoid circular 

    # Import views from crud package
    from apps.crud import views as crud_views

    # Register views in crud (Blueprint object) to app with register_blueprint function
    # Allow all the routes defined in the 'crud' blueprint will stat like crud/~
    app.register_blueprint(crud_views.crud, url_prefix="/crud")


    #Import views from auth package
    from apps.auth import views as auth_views

    #Register crud_views.auth with register_blueprint
    app.register_blueprint(auth_views.auth, url_prefix="/auth")

    return app

# Run apps when it is directly called.
if __name__ == "__main__":
    app = create_app()
    app.run(debug=True)