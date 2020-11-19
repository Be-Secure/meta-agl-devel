SUMMARY = "base-files for AGL software"
DESCRIPTION = "install base-files to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

BBCLASSEXTEND = "native nativesdk"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=agl-basefiles/files/;branch=master"
SRCREV := "${BASESYSTEM_SRCREV}"

FILES_${PN} += " \
    /files/bin/* \
    /files/agldd/* \
    /files/include/* \
    /files/BS/ns/npp/rwdata/* \
    /files/share/* \
    ${CONFDIR}/backup_manager/* \
    ${CONFDIR}/systemmanager/* \
    ${NVPATH}/files/BS/ns/npp/rwdata/* \
"

FILES_${PN}-dev += " \ 
    ${SHAREDIR}/* \
    ${INCLUDEDIR}/* \
    ${INCLUDEDIR}/files/agldd/* \
    ${INCLUDEDIR}/linux/* \
"
S = "${WORKDIR}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_package_qa[noexec] = "1"
do_install[depends] += "virtual/kernel:do_shared_workdir"

do_install() {
        install -C -d ${D}${SHAREDIR}/
        install -C -d ${D}${INCLUDEDIR}/files/agldd/
        install -C -d ${D}${INCLUDEDIR}/linux/
        install -C -d ${D}${NVPATH}/files/BS/ns/npp/rwdata/
        install -m 644 ${WORKDIR}/files/agldd/* ${D}${INCLUDEDIR}/files/agldd/
        install -m 644 ${WORKDIR}/files/share/* ${D}${SHAREDIR}/
        install -m 644 ${WORKDIR}/files/BS/ns/npp/rwdata/* ${D}${NVPATH}/files/BS/ns/npp/rwdata
        install -m 775 ${WORKDIR}/files/bin/launch_xml2cfg.sh ${D}${SHAREDIR}/
        install -D -m 0644 ${TMPDIR}/work-shared/${MACHINE}/kernel-build-artifacts/files/include/generated/autoconf.h ${D}${INCLUDEDIR}/linux/
}

sysroot_stage_all_append(){
	sysroot_stage_dir ${D}/usr ${SYSROOT_DESTDIR}${base_prefix}/usr
}

