SUMMARY = "agl-service-vs-positioning for AGL software"
DESCRIPTION = "agl-service-vs-positioning to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ss-config \
    ss-interfaceunified \
    ss-versionlibrary \
    ns-frameworkunified \
    ns-commonlibrary \
    ns-backupmanager \
    os-vehicleparameterlibrary \
    os-eventlibrary \
    ps-communication \
    libpositioning-hal \
    vs-positioningbaselibrary \
    vs-positioning \
    ps-communicationusb \
    vs-clock \
    vs-vehicle \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/vehicle/positioning"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.server"
EXTRA_OEMAKE += "'CXX=${CXX} -Wl,--warn-unresolved-symbols' 'CC=${CC} -Wl,--warn-unresolved-symbols' "

FILES_${PN}-staticdev += "${libdir}/*/*.a"

RDEPENDS_${PN} += " \
    ss-config \
    ss-interfaceunified \
    ss-versionlibrary \
    ns-frameworkunified \
    ns-commonlibrary \
    ns-backupmanager \
    os-vehicleparameterlibrary \
    os-eventlibrary \
    ps-communication \
    libpositioning-hal \
    vs-positioningbaselibrary \
    vs-positioning \
    vs-clock \
    vs-vehicle \
"

CAPABILITY = "cap_dac_override+ep:/usr/bin/Positioning"
