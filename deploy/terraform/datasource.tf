data "aws_ami" "thehome_server_ami" {
  most_recent = true
  owners      = ["137112412989"]

  filter {
    name   = "name"
    values = ["al2023-ami-2023.2.20231113.0-kernel-6.1-x86_64"]
  }
}