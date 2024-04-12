#!/bin/bash

# Define the URL
URL="http://localhost:8080/log"

# Define the file that contains the JSON data to POST
POST_FILE="post_data.json"

# Define the Content-Type
CONTENT_TYPE="application/json"

# Use Apache Bench to send the POST requests
ab -n 1000 -c 10 -p $POST_FILE -T $CONTENT_TYPE $URL