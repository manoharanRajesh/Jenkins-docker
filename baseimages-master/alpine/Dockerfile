FROM alpine

ARG BUILD_DATE=undefined

ENV WORKSHOP_HOME=/var/rajeshmanoharan \
    DOCKERIZE_VERSION=v0.6.0

RUN apk upgrade --update && \
    apk add \
      bash \
      tzdata \
      vim \
      tini \
      su-exec \
      gzip \
      tar \
      wget \
      curl && \
    # Network fix
    echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
    # Rajeshmanoharan Feature Script Folder
    mkdir -p ${WORKSHOP_HOME} && \
    # Install dockerize
    wget -O /tmp/dockerize.tar.gz https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz && \
    tar -C /usr/local/bin -xzvf /tmp/dockerize.tar.gz && \
    # Clean up
    apk del curl \
      wget && \
    rm -rf /var/cache/apk/* && \
    rm -rf /tmp/* && \
    rm -rf /var/log/*

COPY imagescripts/ ${WORKSHOP_HOME}/
COPY imagescripts/dockerwait.sh /usr/bin/dockerwait


