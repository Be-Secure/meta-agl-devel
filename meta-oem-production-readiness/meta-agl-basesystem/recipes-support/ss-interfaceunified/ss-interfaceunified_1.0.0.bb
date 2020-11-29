SUMMARY = "ss-interfaceunified for AGL software"
DESCRIPTION = "ss-interfaceunified to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ss-romaccesslibrary \
    ns-commonlibrary \
    ns-frameworkunified \
    elfio \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/system;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/system/interface_unified"

inherit agl-basesystem-common

EXTRA_MAKEFILE = " -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"

FILES_${PN} += "${libdir}/*"

RDEPENDS_${PN} += " \
    elfio \
    ns-commonlibrary \
    ns-frameworkunified \
    ss-romaccesslibrary \
"
