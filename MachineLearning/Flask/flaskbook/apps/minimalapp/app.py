#import  Flask
from flask import Flask

#Instantiate Flask class
app = Flask(__name__)

#Mapping function and URL
@app.route("/")
def index():
    return "Hello, Flaskbook!"