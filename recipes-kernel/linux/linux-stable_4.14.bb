FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.14.28"
KBRANCH ?= "linux-4.14.y"
SRCREV ?= "42b96e19dddd6fa35aba5f57f8bcc284a4c3049d"

require linux-stable.inc

SRC_URI += "file://meson64.scc \
            file://touchscreen.cfg \
"
