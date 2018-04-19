FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.16.2"
KBRANCH ?= "linux-4.16.y"
SRCREV ?= "216f33936eaa006a8b4f5bb992592e34f6432fc2"

require linux-stable.inc

SRC_URI_append = " file://odroid.scc"
SRC_URI_append_odroid-xu3 = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu3-lite = " file://${O_KERNEL_CONFIG}/fb.cfg"
SRC_URI_append_odroid-xu4 = " file://${O_KERNEL_CONFIG}/fb.cfg"
