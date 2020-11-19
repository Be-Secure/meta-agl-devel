SUMMARY = "os-rpclibrary for AGL software"
DESCRIPTION = "os-rpclibrary to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

FILES_${PN} += " \
    ${LIBDIR}/* \
"
FILES_${PN}-dev += "${INCLUDEDIR}/*"
 
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=otherservice/;branch=master"
SRCREV := "${BASESYSTEM_SRCREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

#Added here because they are native recipes, although they are AGLs
DEPENDS += " \
    ns-commonlibrary \
    ns-loglibrary \
    bison-native \
"

inherit agl-basesystem-common

RDEPENDS_${PN} += " \
    ns-commonlibrary \
    ns-loglibrary \
"
EXTRA_MAKEFILE=" -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"
MAKE_DIR ="rpc_library"

