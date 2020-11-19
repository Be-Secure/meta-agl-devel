SUMMARY = "vs-diagrecord for AGL software"
DESCRIPTION = "vs-diagrecord to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

FILES_${PN} += " ${LIBDIR}/* "
FILES_${PN}-dev += "${INCLUDEDIR}/*"

FILES_${PN}-staticdev = "${LIBDIR}/*.a"
 
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=stub/;branch=master"
SRCREV := "${BASESYSTEM_SRCREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " ns-frameworkunified"

inherit agl-basesystem-common

MAKE_DIR ="diag_record"

EXTRA_MAKEFILE = " -f Makefile"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"

