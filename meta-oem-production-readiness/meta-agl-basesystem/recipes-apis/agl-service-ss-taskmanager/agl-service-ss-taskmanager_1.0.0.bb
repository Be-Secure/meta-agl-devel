SUMMARY = "agl-service-ss-taskmanager for AGL software"
DESCRIPTION = "agl-service-ss-taskmanager to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    os-rpclibrary-tool-native \
    ss-interfaceunified \
    ss-resourcemanager \
    ss-romaccesslibrary \
    ss-taskmanager \
    ns-frameworkunified \
    ns-commonlibrary \
    os-eventlibrary \
    os-rpclibrary \
    os-vehicleparameterlibrary \
    libxml2-native \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/system;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/system/task_manager"

inherit agl-basesystem-common

EXTRA_MAKEFILE=" -f Makefile.server"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE} 'CXX=${CXX} -Wl,--warn-unresolved-symbols' 'CC=${CC} -Wl,--warn-unresolved-symbols'"
EXTRA_OEMAKE += "'OECORE_NATIVE_SYSROOT=${STAGING_DIR_NATIVE}'"

do_compile_prepend() {
    oe_runmake -f Makefile.client
}

RDEPENDS_${PN} += " \
    ss-interfaceunified \
    ss-resourcemanager \
    ss-romaccesslibrary \
    ss-taskmanager \
    ns-frameworkunified \
    ns-commonlibrary \
    os-eventlibrary \
    os-rpclibrary \
    os-vehicleparameterlibrary \
"

CAPABILITY = "cap_sys_nice,cap_setuid,cap_setgid=ep:/usr/bin/tskmgr"
