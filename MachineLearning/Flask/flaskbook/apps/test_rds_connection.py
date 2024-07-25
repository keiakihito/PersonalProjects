import os
import psycopg2
from dotenv import load_dotenv

# Load environment variables from a .env file
load_dotenv()

def test_connection():
    try:
        # Get the connection parameters from environment variables
        DB_USER = os.getenv('DB_USER')
        DB_PASSWORD = os.getenv('DB_PASSWORD')
        DB_HOST = os.getenv('DB_HOST')
        DB_PORT = os.getenv('DB_PORT')
        DB_NAME = os.getenv('DB_NAME')

        # Connect to the PostgreSQL database
        connection = psycopg2.connect(
            user=DB_USER,
            password=DB_PASSWORD,
            host=DB_HOST,
            port=DB_PORT,
            database=DB_NAME
        )

        cursor = connection.cursor()

        # Execute a test query
        cursor.execute("SELECT version();")
        record = cursor.fetchone()
        print("You are connected to - ", record, "\n")

        # Close the connection
        cursor.close()
        connection.close()
    except (Exception, psycopg2.Error) as error:
        print("Error while connecting to PostgreSQL", error)

if __name__ == "__main__":
    test_connection()
