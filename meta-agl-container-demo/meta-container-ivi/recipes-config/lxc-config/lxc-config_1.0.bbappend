FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

GUEST_NAME := "GUEST_IVI"
GUEST_MAC_ADDR := "00:16:3e:cf:07:fe"

SRC_URI_append = " \
    file://00_rootfs.cfg \
    file://100_weston.cfg \
    file://101_snd.cfg \
    file://102_usb.cfg \
    file://103_bluetooth.cfg \
    file://104_radio.cfg \
    "

do_install_append() {
    # set path of rootfs
    sed -i -e "s/%%name%%/${GUEST_NAME}/" ${D}/config

    # set network interface
    sed -i -e "/lxc.net.0.type/s/=\(.*\)/ = veth\n\
lxc.net.0.name = eth0\n\
lxc.net.0.link = lxcbr0\n\
lxc.net.0.flags = up\n\
lxc.net.0.veth.mode = bridge\n\
lxc.net.0.hwaddr = ${GUEST_MAC_ADDR}/" \
              ${D}/config
}
