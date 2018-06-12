FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.43"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "1dff08485b9e835d00bfb34a435bc6f07dadb6fd"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
