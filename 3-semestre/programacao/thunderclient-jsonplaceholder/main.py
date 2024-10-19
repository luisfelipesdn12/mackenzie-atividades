import requests
import json
import os

BASE_URL = "https://jsonplaceholder.typicode.com"
ENDPOINTS = ["albums", "photos", "todos", "users"]
OPERATIONS = ["GET", "POST", "PUT", "DELETE"]

def create_directory(dir_name):
    if not os.path.exists(dir_name):
        os.makedirs(dir_name)

def perform_operation(endpoint, operation):
    url = f"{BASE_URL}/{endpoint}"
    
    if operation == "GET":
        response = requests.get(url)
    elif operation == "POST":
        data = {"title": "New Item", "body": "This is a new item.", "userId": 1}
        response = requests.post(url, json=data)
    elif operation == "PUT":
        data = {"id": 1, "title": "Updated Item", "body": "This item has been updated.", "userId": 1}
        response = requests.put(f"{url}/1", json=data)
    elif operation == "DELETE":
        response = requests.delete(f"{url}/1")
    
    return response.json()

def save_response(data, endpoint, operation):
    filename = f"lab08/{endpoint}-{operation}.json"
    with open(filename, 'w') as f:
        json.dump(data, f, indent=2)

def main():
    create_directory("lab08")
    
    for endpoint in ENDPOINTS:
        for operation in OPERATIONS:
            print(f"Performing {operation} on {endpoint}...")
            response_data = perform_operation(endpoint, operation)
            save_response(response_data, endpoint, operation)
            print(f"Saved result to lab08/{endpoint}-{operation}.json")

if __name__ == "__main__":
    main()
