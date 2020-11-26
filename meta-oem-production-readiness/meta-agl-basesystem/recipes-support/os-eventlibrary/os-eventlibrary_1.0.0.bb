SUMMARY = "os-eventlibrary for AGL software"
DESCRIPTION = "os-eventlibrary to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

FILES_${PN} += "${libdir}/*"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/other;branch=${AGL_BRANCH}"
SRCREV := "${AGL_DEFAULT_REVISION}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/other"

inherit agl-basesystem-common

RDEPENDS_${PN} += " \
    kernel-module-evklib \
"

EXTRA_MAKEFILE=" -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"
MAKE_DIR ="event_library"
