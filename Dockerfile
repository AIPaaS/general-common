# Pull base image
FROM 10.19.13.18:5000/jdk:7 
MAINTAINER gucl<gucl@asiainfo.com>
WORKDIR /

# deploy user dubbo service
COPY ./build/libs /general-common-service/libs/
COPY ./build/config /general-common-service/config/

#mkdir logs path
RUN cd /general-common-service && mkdir logs && cd /general-common-service/logs && mkdir ch-logs && mkdir slp-logs

## copy start script
COPY ./script/general-common-service.sh /general-common-service.sh
RUN chmod 755 /general-common-service.sh

# set start parameter for dubbo service
ENV COMMON_LIB_HOME /general-common-service

# Expose ports.
EXPOSE 18881

# Define default command.
CMD ["./general-common-service.sh"]