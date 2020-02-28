FROM centos:7
RUN curl -sL https://rpm.nodesource.com/setup_10.x | bash - && \
    yum install -y wget which nodejs java-1.8.0-openjdk-devel
RUN wget http://ftp.byfly.by/pub/apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -O /tmp/apache-maven-3.6.3-bin.tar.gz && \
    tar -xzvf /tmp/apache-maven-3.6.3-bin.tar.gz && \
    mv apache-maven-3.6.3 /opt/
ENV PATH="${PATH}:/opt/apache-maven-3.6.3/bin"