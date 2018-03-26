# Supported Tags And Respective Dockerfile Links

| Base Image   | Tag          |Version| Dockerfile | Readme |
|--------------|--------------|-------|------------|--------|
| manoharanrajesh/baseimages |alpine |3.7      | [Dockerfile](alpine/Dockerfile) | [README.md](alpine/README.md) |
| manoharanrajesh/baseimages |centos |7.4.1708  | [Dockerfile](centos/Dockerfile) | [README.md](README.md) |
| manoharanrajesh/baseimages |ubuntu |  18.04   | [Dockerfile](ubuntu/Dockerfile) | [README.md](README.md) |


# baseimages:alpine

manoharanrajesh Alpine Base Image

* Includes repository updates
* tini: Zombie Process Reaper
* su-exec: Execute processes as different user
* wait-for-it: Waiting for available server ports.
* Feature Script: Runtime user definition with environment variables.

[README.md](alpine/README.md)

[Dockerhub Repository](https://hub.docker.com/r/manoharanrajesh/baseimages/)

# manoharanrajesh/centos

* Includes updates

## Build the Image

~~~~
$ cd centos && docker build -t manoharanrajesh/centos .
~~~~

## Run the Image

~~~~
$ docker run -it --rm manoharanrajesh/centos bash
~~~~

# manoharanrajesh/ubuntu

## Build the Image

~~~~
$ cd ubuntu && docker build -t manoharanrajesh/ubuntu .
~~~~

## Run the Image

~~~~
$ docker run -it --rm manoharanrajesh/ubuntu bash
~~~~
