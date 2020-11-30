SUMMARY = "ns-frameworkunified for AGL software"
DESCRIPTION = "ns-frameworkunified to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    os-posixbasedos001legacylibrary \
    ns-loglibrary \
    ns-commonlibrary \
    libxml2 \
    boost \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/native;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/native/framework_unified"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.library -f Makefile.client"

FILES_${PN} += "${libdir}/*"

RDEPENDS_${PN} += " \
    os-posixbasedos001legacylibrary \
    ns-loglibrary \
    ns-commonlibrary \
"
