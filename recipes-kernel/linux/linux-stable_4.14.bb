FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"


LINUX_VERSION ?= "4.14"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "bebc6082da0a9f5d47a1ea2edc099bf671058bd4"

O_KERNEL_CONFIG_odroid-c2  = "odroid-c2"
O_KERNEL_CONFIG_odroid-c1  = "odroid-c1"

require linux-stable.inc

DEPENDS += "u-boot-mkimage-native"

do_compile_append_odroid-c2 () {
	uboot-mkimage -A arm64 -O linux -T kernel -C none -a 0x1080000 -e 0x1080000 -n master -d ${B}/arch/${ARCH}/boot/Image ${KERNEL_OUTPUT_DIR}/uImage
}

do_install_append_odroid-c2 () {
	install -m 0644 ${KERNEL_OUTPUT_DIR}/uImage ${D}/${KERNEL_IMAGEDEST}/uImage
}

do_deploy_append_odroid-c2 () {
	 install -m 0644 ${D}/${KERNEL_IMAGEDEST}/uImage ${DEPLOY_DIR_IMAGE}/uImage
} 

COMPATIBLE_MACHINE = "(odroid-c1|odroid-c2|odroid-xu3|odroid-xu4|odroid-xu3-lite|odroid-xu4s)"
