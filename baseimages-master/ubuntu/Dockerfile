FROM ubuntu:18.04

ARG BUILD_DATE=undefined

RUN apt-get update && \
    apt-get -y dist-upgrade && \
    apt-get autoclean && \
    rm -rf /tmp/* && rm -rf /var/log/*

