#! /bin/sh

source ./_env.sh

ant -Dtarget=dev-rp-01 _hot_deploy-remote-jboss
