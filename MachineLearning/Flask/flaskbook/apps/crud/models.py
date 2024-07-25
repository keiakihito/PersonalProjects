from datetime import datetime
from werkzeug.security import generate_password_hash
from flask_sqlalchemy import SQLAlchemy


db = SQLAlchemy()

#Define User class which inherits db.Model
class User(db.Model):
    #Choose the Table Name
    __tablename__ = "users"

    #Column definition
    id = db.Column(db.Integer, primary_key = True)
    username = db.Column(db.String, index = True)
    email = db.Column(db.String, unique = True, index = True)
    password_hash = db.Column(db.String)
    created_at = db.Column(db.DateTime, default = datetime.now)
    updated_at = db.Column(
        db.DateTime, default = datetime.now, onupdate = datetime.now
    )

    #Property for setting password
    @property
    def password(self):
        raise AttributeError("!!Unable to read!!")

    #Set password hashed by the setter
    @password.setter
    def password(self, password):
        self.password_hash = generate_password_hash(password)