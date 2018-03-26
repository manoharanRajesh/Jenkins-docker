FROM manoharanrajesh/java:ubuntu.jdk.8

MAINTAINER manoharan rajesh

ENV NODEJS_VERSION=v9.9.0 YARN_VERSION=1.5.1


RUN apt-get -y install curl libcurl4 xz-utils tar

RUN curl -SLO "https://nodejs.org/dist/$NODEJS_VERSION/node-$NODEJS_VERSION-linux-x64.tar.xz" \
    && tar -Jxvf "node-$NODEJS_VERSION-linux-x64.tar.xz" -C /usr/local --strip-components=1 --no-same-owner \
    && ln -s /usr/local/bin/node /usr/local/bin/nodejs \
    &&  rm "node-$NODEJS_VERSION-linux-x64.tar.xz" \
    && curl -fSLO --compressed "https://yarnpkg.com/downloads/$YARN_VERSION/yarn-v$YARN_VERSION.tar.gz" \
    && mkdir -p /opt \
    && tar -xzf yarn-v$YARN_VERSION.tar.gz -C /opt/ \
    && ln -s /opt/yarn-v$YARN_VERSION/bin/yarn /usr/local/bin/yarn \
    && ln -s /opt/yarn-v$YARN_VERSION/bin/yarnpkg /usr/local/bin/yarnpkg \
    && rm yarn-v$YARN_VERSION.tar.gz
