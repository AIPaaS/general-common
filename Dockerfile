# Pull base image
FROM 10.19.13.18:5000/jdk:7 
MAINTAINER gucl<gucl@asiainfo.com>
WORKDIR /

# deploy user dubbo service
COPY ./build/libs /dubbo-service/libs/
COPY ./build/config /dubbo-service/config/

#mkdir logs path
RUN cd /dubbo-service && mkdir logs && cd /dubbo-service/logs

## copy start script
COPY ./script/start-dubbo-service.sh /start-dubbo-service.sh
RUN chmod 755 /start-dubbo-service.sh

# Expose dubbo/rest ports.
EXPOSE 10885

# Define default command.
CMD ["./start-dubbo-service.sh"]