SUMMARY = "The software for the AGL Alexa voiceagent feature"
DESCRIPTION = "The software for the AGL Alexa voiceagent feature"

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-voiceagent-alexa \
    "

RDEPENDS:${PN} = " \
    alexa-voiceagent-service \
    "
