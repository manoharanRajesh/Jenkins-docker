# Supported Tags And Respective Dockerfile Links

| Base Image   | Tag          | Dockerfile | Readme |
|--------------|--------------|------------|--------|
| rajeshmanoharan/alpine | latest, 3.6 | [Dockerfile](alpine/Dockerfile) | [README.md](alpine/README.md) |
| rajeshmanoharan/centos | latest, 7, 7.4 , 7.4.1708 | [Dockerfile](centos/Dockerfile) | [README.md](README.md) |
| rajeshmanoharan/ubuntu | latest, 18, 18.04 | [Dockerfile](ubuntu/Dockerfile) | [README.md](README.md) |


# rajeshmanoharan/alpine

rajeshmanoharan Alpine Base Image

* Includes repository updates
* tini: Zombie Process Reaper
* su-exec: Execute processes as different user
* wait-for-it: Waiting for available server ports.
* Feature Script: Runtime user definition with environment variables.

[README.de](alpine/README.md)

[Dockerhub Repository](https://hub.docker.com/rajeshmanoharan/alpine/)

# rajeshmanoharan/centos

* Includes updates

## Build the Image

~~~~
$ cd centos && docker build -t rajeshmanoharan/centos .
~~~~

## Run the Image

~~~~
$ docker run -it --rm rajeshmanoharan/centos bash
~~~~

# rajeshmanoharan/ubuntu

## Build the Image

~~~~
$ cd ubuntu && docker build -t rajeshmanoharan/ubuntu .
~~~~

## Run the Image

~~~~
$ docker run -it --rm rajeshmanoharan/ubuntu bash
~~~~
