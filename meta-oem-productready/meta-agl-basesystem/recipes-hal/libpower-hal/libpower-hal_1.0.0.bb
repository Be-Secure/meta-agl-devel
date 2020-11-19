SUMMARY = "libpower_hal for AGL software"
DESCRIPTION = "install libpower_hal to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

FILES_${PN}-dev += "${INCLUDEDIR}/peripheral_service/*"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=power_hal/;branch=master"
SRCREV := "${BASESYSTEM_SRCREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " ns-frameworkunified"

inherit agl-basesystem-hal

HAL_NAME = "power_hal"
