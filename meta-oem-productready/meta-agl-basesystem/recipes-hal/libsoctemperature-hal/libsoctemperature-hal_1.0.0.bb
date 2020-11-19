SUMMARY = "libsoc_temperature-hal for AGL software"
DESCRIPTION = "install libsoc_temperature-hal to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

FILES_${PN} += "${INCLUDEDIR}/system_service/*"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=soc_temperature_hal/;branch=master"
SRCREV := "${BASESYSTEM_SRCREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += " ns-frameworkunified"

inherit agl-basesystem-hal

HAL_NAME = "soc_temperature_hal"
