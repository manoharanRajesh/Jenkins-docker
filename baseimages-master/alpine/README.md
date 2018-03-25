# Rajeshmanoharan Docker Base Image


Alpine images are smaller than full distributions, e.g. CentOS. This is a base image with some tweaks based on the official alpine image on Dockerhub.

Image Features:

* Includes repository updates
* tini: Zombie Process Reaper
* su-exec: Execute processes as different user
* wait-for-it: Waiting for available server ports.
* Feature Script: Runtime user definition with environment variables.

# Build the Image

~~~~
$ cd alpine && docker build -t rajeshmanoharan/alpine .
~~~~

# Run the Image

~~~~
$ docker run -it --rm rajeshmanoharan/alpine bash
~~~~

# Rajeshmanoharan Dockerwait Feature

The Rajeshmanoharan Dockerwait Feature is a script for polling server ports. This is mandatory when you want to wait for other containers starting web servers or databases.

You can define a the waiting parameters with the enviromnemt variables:

* `DOCKER_WAIT_HOST`: The host to poll. Mandatory!
* `DOCKER_WAIT_PORT`: The port to poll Mandatory!
* `DOCKER_WAIT_TIMEOUT`: The timeout in seconds. Optional! Default: 60
* `DOCKER_WAIT_INTERVAL`: The polling interval in seconds. Optional! Default:5

Example waiting for a postgresql database:

First start the polling container:

~~~~
$ docker network create testnetwork
$ docker run \
    --net testnetwork \
    -e "DOCKER_WAIT_HOST=postgres" \
    -e "DOCKER_WAIT_PORT=5432" \
    rajeshmanoharan/alpine dockerwait
~~~~

> Waits at most 60 seconds for the database.

Secondly start the database:

~~~~
$ docker run -d --name postgres \
    --net testnetwork --hostname postgres \
    -e 'POSTGRES_USER=postgres' \
    -e 'POSTGRES_PASSWORD=postgres' \
    postgres:9.4
~~~~

> Starts postgres database under hostname `postgres` in docker network `testnetwork`

You can integrate this feature inside your entrypoint:

~~~~
#!/bin/bash

# Use The Feature Script
source /usr/bin/dockerwait
# Executing The Application
exec your_application_command_here
~~~~

> Simple entrypoint.sh script example.

# Rajeshmanoharan User Feature

The Rajeshmanoharan User Feature is a script for specifiying the run user of your application with env variables.
The user will be created automatically and can be user inside your entrypoint to start your application using `su-exec`.

You can define a user for your application at startup with the environment variables:

* `DOCKER_USER`: The user's name, should match a valid username on your host machine (Default: rajeshmanoharan).
* `DOCKER_USER_ID`: The user's id should match a valid id on your host machine (Default: 1000).
* `DOCKER_USERGROUP`: The user's groupname, should match a valid groupname on your host machine (Default: rajeshmanoharan).
* `DOCKER_USERGROUP_ID`: The user's groupid, should match a valid goup id on your host machine (Default: 1000).

Example Use Case:

~~~~
$ docker run \
    -e "DOCKER_USER=YourUser" \
    -e "DOCKER_USER_ID=2000" \
    -e "DOCKER_USERGROUP=YourGroup" \
    -e "DOCKER_USERGROUP_ID=2000" \
    rajeshmanoharan/alpine ./var/rajeshmanoharan/createuser.sh
~~~~

In order to make this work you will have to hook this script in your individual entrypoint script:

~~~~
#!/bin/bash

# Include The Feature Script
source /var/rajeshmanoharan/dockeruser.sh
# Create The User
dockerUser
# Print User Information
printUserInfo
# Executing The Application
exec su-exec $CURRENT_DOCKER_USER your_application_command_here
~~~~

> Simple entrypoint.sh script example.

# Using tini

Tini is used to wrap your images entrypoint!

More information: [krallin/tini](https://github.com/krallin/tini)

Example:

~~~~
ENTRYPOINT ["/sbin/tini","--","/yourpath/docker-entrypoint.sh"]
~~~~

> Will start your entrypoint under tini process management.

# Using su-exec

Su-Exec C reimplementation of gosu! Simplified sudo to exec processes under different users.

More information: [ncopa/su-exec](https://github.com/ncopa/su-exec)

Use su-exec in your individual entrypoint script:

~~~~
#!/bin/bash

# Executing The Application
exec su-exec your_user your_application_command_here
~~~~

> Simple entrypoint.sh script example.

# Using dockerize

Dockerize is a tool that allows to wait for available ports and sites on the network.

More information: [jwilder/dockerize](https://github.com/jwilder/dockerize)

Example waiting for a database and website:

~~~~
$ dockerize -wait tcp://db:5432 -wait http://web:80 -timeout 10s
~~~~

> The parameter `-wait` can be used arbitrary times.

# Build the Image

~~~~
$ docker build -t rajeshmanoharan/alpine .
~~~~

# Run the Image

~~~~
$ docker run -it --rm rajeshmanoharan/alpine bash
~~~~


