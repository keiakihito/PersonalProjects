#import  Flask
# g,  A global namespace for holding any data you want during the application context.
from flask import Flask, render_template, url_for, current_app, g,request

#Instanciate Flask class
#__name__ variable is used to determine the root path for the application
app = Flask(__name__)

#Mapping function and URL
@app.route("/")
def index():
    return "Hello, Flaskbook!"

#decorator creates a route for the URL pattern
#<name> is a dynamic part of the URL
#GET requests are typically used to retrieve data.
#POST requests are typically used to submit data to the server (e.g., form submissions).
#The endpoint parameter allows you to name the endpoint for the route.
@app.route("/hello/<name>",
           methods = ["GET", "POST"],
           endpoint="hello-endpoint")
def hello(name):
    return f"Hello, {name}!"


#render_template Function:
#Combines an HTML template with the variables you pass to it,
#Generating dynamic HTML content.
@app.route("/name/<name>")
def show_name(name):
    #Passing variable to the template engine
    return render_template("index.html", name=name)


@app.route("/context")
def show_context():
    # Ensure the application context is active
    with app.app_context():
        # Access current_app and g
        context_info = {
            "current_app_name": current_app.name,
            "g_connection": g.get('connection', 'Not set')
        }
        return context_info


# Request context
# url_for helps avoid hardcoding URLs in your templates and code
# making your application more maintainable and flexible.
# with app.test_request_context(): creates a block of code that simulates a request context.
# verify that the URL generation is working correctly.
# It ensures that url_for is producing the expected URLs for routes.
with app.test_request_context():
    # /
    # Generates the URL for the index view function. This will output /.
    print(url_for("index"))

    # /hello/world
    # Generates the URL for the hello view function, passing "world" as the name parameter.
    print(url_for("hello-endpoint", name="world"))

    # /name/keita?page=1
    # Generates the URL for the show_name view function,
    # passing "keita" as the name parameter
    # adding a query parameter page=1.
    print(url_for("show_name", name="keita", page="1"))

# Application context, which is pushed to the stack
# print(current_app)
# Getting application context and push to stack
ctx = app.app_context()
ctx.push()

# Enable to access to the current_app
print(current_app.name)
# >>apps.minimalapp.app

# Set value in the g, a global namespace for holding any data during the application context
g.connection = "connection"
print(g.connection)


with app.test_request_context("/user?updated=true"):
    #Output true on the console
    print(request.args.get("updated"))


#In Flask, you typically don't define a main function.
#Instead, the Flask application instance (app) serves as the central object.
#Run the application only if this script is executed directly
if __name__ == "__main__":
    app.run()