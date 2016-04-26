inherit kernel
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV ?= "6fe78bc1bfcddabbf3d210e18f91da44fa796d8a"

SRCREV_machine_odroid-xu3 ?= "6fe78bc1bfcddabbf3d210e18f91da44fa796d8a"

KERNEL_DEVICETREE_odroid-xu3 = "exynos5422-odroidxu3.dtb"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;bareclone=1;branch=linux-4.1.y"

SRC_URI += "file://defconfig"

LINUX_VERSION = "4.1.22"
PV = "${LINUX_VERSION}+git${SRCPV}"

KCONF_BSP_AUDIT_LEVEL = "0"

COMPATIBLE_MACHINE_odroid-xu3  = "odroid-xu3"
