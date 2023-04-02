#!/usr/bin/env bash

export RUNCRUD_HOME=/Users/karol/Dev/tasks/

runcrud()
 {
     zsh $RUNCRUD_HOME/runcrud.sh start
     end
 }

 end() {
    echo "Work is finished, the runcrud scrypt has started."
 }

 fail() {
    echo "Sorry, problems with runcrud script."
 }

 browser()
 {
     open -a "Safari" http://localhost:8080/crud/v1/tasks
 }

 if runcrud; then
     browser
     echo "Success! Safari is opened and URLs works."
 else
     fail
 fi