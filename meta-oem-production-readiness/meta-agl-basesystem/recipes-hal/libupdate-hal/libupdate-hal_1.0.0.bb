SUMMARY = "libupdate_hal for AGL software"
DESCRIPTION = "install libupdate_hal to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=hal/update_hal;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/update_hal"

inherit agl-basesystem-hal

HAL_NAME = "update_hal"
FILES_${PN} += "${libdir}"
