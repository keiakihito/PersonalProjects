from flask import Flask

#Instantiate app with Create_app function
#It makes easier to switch test  and production environment
def create_app():
    #Instantiate Flask app
    app = Flask(__name__)

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

