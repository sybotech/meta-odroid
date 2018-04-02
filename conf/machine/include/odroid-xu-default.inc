# Odroid XU default BSP

include conf/machine/include/samsung-exynos.inc
include conf/machine/include/odroid-default-settings.inc

DEFAULTTUNE = "cortexa15hf-neon"
include conf/machine/include/tune-cortexa15.inc

PREFERRED_VERSION_linux-stable = "4.15%"

EXTRA_IMAGEDEPENDS += "secure-odroid"

UBOOT_FDT_LOADADDR = "0x40800000"
UBOOT_LOADADDR = "0x40007FC0"
UBOOT_LOADADDRESS = "0x40007FC0"
UBOOT_CONSOLE = "console=ttySAC2,115200"
UBOOT_KERNEL_NAME = "zimage"

#odroid-xu general
UBOOT_B2_POS = "31"
UBOOT_BIN_POS = "63"
UBOOT_TZSW_POS = "2111"
UBOOT_ENV_POS = "2625"
