FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LINUX_VERSION ?= "4.16-rc7"
KBRANCH ?= "master"
SRCREV ?= "3eb2ce825ea1ad89d20f7a3b5780df850e4be274"

require linux-mainline.inc

SRC_URI_append_odroid-xu3 = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu3-lite = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu4 = " file://${O_KERNEL_CONFIG}/fb.cfg"
