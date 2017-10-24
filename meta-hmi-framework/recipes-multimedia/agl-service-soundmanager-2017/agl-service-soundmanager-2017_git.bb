SUMMARY     = "Sound Manager binding"
ESCRIPTION = "Sound Manager is the binding library to communicate \
	with Genivi Audio Manager. Genivi Audio Manager is the policy manager \
	"
HOMEPAGE    = "https://wiki.automotivelinux.org/soundmanager"
S = "${WORKDIR}/git"
SECTION = "multimedia"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"
DEPENDS = "dbus glib-2.0 af-binder json-c"
RDEPENDS_${PN} = "audiomanager audiomanager-plugins"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-soundmanager-2017;protocol=https;branch=master"
SRCREV = "693a0cfd691d7089238407b9a418a02a77401221"

inherit cmake aglwgt

do_install_append() {
	install -d ${D}${sysconfdir}/dbus-1/system.d
	install -m 0644 ${S}/conf/soundmanager-dbus.conf ${D}${sysconfdir}/dbus-1/system.d/
}

FILES_${PN} += "${sysconfdir}/dbus-1/system.d/soundmanager-dbus.conf"