#!/bin/sh

for file in ${COMMON_LIB_HOME}/libs/**/*.jar;
do CP=${CP}:$file;
done

DUBBO_CONFIG_PATH=${COMMON_LIB_HOME}/config
LOG_PATH=${COMMON_LIB_HOME}/logs/general-common-rest.log
CLASSPATH="${CP}"
CLASSPATH="${DUBBO_CONFIG_PATH}:${CLASSPATH}"
export CLASSPATH

MEM_ARGS="-Xms256m -Xmx512m -XX:PermSize=64M -XX:MaxPermSize=128M"
JAVA_OPTIONS="-Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10 -Ddubbo.provider.timeout=20000 -Djava.security.egd=file:/dev/./urandom"

echo"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"
START_CMD="${MEM_ARGS} -Ddubbo.registry.address=${REST_REGISTRY_ADDR} -Dplatform.common.dubbo.port=${REST_PORT} -Ddubbo.protocol.contextpath=${CONTEXT_PATH} -Ddubbo.protocol=${PROTOCOL} ${JAVA_OPTIONS} com.ai.opt.sdk.appserver.DubboServiceStart  >> $LOG_PATH & 2 > 1 &"

echo ${JAVA_HOME}
echo ${CLASSPATH}
echo ${DUBBO_PORT}
echo ${START_CMD}
sed -i "s/paas.sdk.mode=.*/paas.sdk.mode=${SDK_MODE}/g" ${COMMON_LIB_HOME}/config/paas/paas-conf.properties
sed -i "s/ccs.appname=.*/ccs.appname=${CCS_NAME}/g" ${COMMON_LIB_HOME}/config/paas/paas-conf.properties
sed -i "s/ccs.zk_address=.*/ccs.zk_address=${ZK_ADDR}/g" ${COMMON_LIB_HOME}/config/paas/paas-conf.properties

echo "------------------- general-common service start --------------------"
java ${START_CMD}
echo "------------------- general-common service started! -------------------"
