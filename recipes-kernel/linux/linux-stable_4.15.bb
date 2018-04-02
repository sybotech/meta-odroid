FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.15.12"
KBRANCH ?= "linux-4.15.y"
SRCREV ?= "cfc8d40be91d767121a6f8c148db43c87be349ed"

require linux-stable.inc
SRC_URI_append = " file://0001-exynos5422-odroidhc1.dts-fix-booting-from-mmc.patch"
SRC_URI_append_odroid-xu3 = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu3-lite = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu4 = " file://${O_KERNEL_CONFIG}/fb.cfg"
