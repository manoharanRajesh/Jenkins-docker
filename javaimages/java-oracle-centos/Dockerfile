FROM manoharanrajesh/baseimages:centos

# build parameters
ARG JAVA_DISTRIBUTION=jdk
ARG JAVA_MAJOR_VERSION=8
ARG JAVA_UPDATE_VERSION=161
ARG JAVA_BUILD_NUMBER=12
ARG JAVA_HASH=2f38c3b165be4555a1fa6e98c45e0808
ARG BUILD_DATE=undefined

ENV JAVA_VERSION=1.${JAVA_MAJOR_VERSION}.0_${JAVA_UPDATE_VERSION}
ENV JAVA_HOME=/opt/java/${JAVA_DISTRIBUTION}${JAVA_VERSION}
ENV PATH=$PATH:$JAVA_HOME/bin

# install java
RUN yum install -y \
      tar \
      which \
      wget && \
    export JAVA_TARBALL=${JAVA_DISTRIBUTION}-${JAVA_MAJOR_VERSION}u${JAVA_UPDATE_VERSION}-linux-x64.tar.gz && \
    if  [ -n "${JAVA_HASH}" ]; \
      then JAVA_HASH_EXTENTION='/'$JAVA_HASH'/' ; \
      else JAVA_HASH_EXTENTION= ; \
    fi && \
    wget --directory-prefix=/tmp \
         --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" \
         http://download.oracle.com/otn-pub/java/jdk/${JAVA_MAJOR_VERSION}u${JAVA_UPDATE_VERSION}-b${JAVA_BUILD_NUMBER}${JAVA_HASH_EXTENTION}/${JAVA_TARBALL} && \
    mkdir -p /opt/java && \
    tar -xzf /tmp/${JAVA_TARBALL} -C /opt/java/ && \
    if  [ "${JAVA_DISTRIBUTION}" = "server-jre" ]; \
      then mv /opt/java/jdk${JAVA_VERSION} ${JAVA_HOME} ; \
    fi && \
    alternatives --install /usr/bin/java java ${JAVA_HOME}/bin/java 100 && \
    yum erase -y \
          wget && \
    yum clean all && rm -rf /var/cache/yum/* && \
    rm -rf /tmp/* && rm -rf /var/log/*


