SUMMARY = "agl-service-ss-powerservice for AGL software"
DESCRIPTION = "agl-service-ss-powerserice to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ss-interfaceunified \
    ss-romaccesslibrary \
    ns-frameworkunified \
    os-posixbasedos001legacylibrary \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/system;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/system/power_service"

inherit agl-basesystem-common

EXTRA_MAKEFILE = " -f Makefile.server"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"

RDEPENDS_${PN} += " \
    ss-interfaceunified \
    ss-romaccesslibrary \
    ns-frameworkunified \
    os-posixbasedos001legacylibrary \
"
