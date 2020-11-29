SUMMARY = "agl-service-ps-communication for AGL software"
DESCRIPTION = "agl-service-ps-communication to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ns-frameworkunified \
    ps-communication \
    os-posixbasedos001legacylibrary \
    ss-interfaceunified \
    ss-romaccesslibrary \
    libcan-hal \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/peripheral;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/peripheral/communication"

inherit agl-basesystem-common

EXTRA_MAKEFILE = " -f Makefile.server"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"

RDEPENDS_${PN} += " \
    ns-frameworkunified \
    ps-communication \
    os-posixbasedos001legacylibrary \
    ss-interfaceunified \
    ss-romaccesslibrary \
    libcan-hal \
"

CAPABILITY = "cap_dac_override+ep:/usr/bin/communication"
