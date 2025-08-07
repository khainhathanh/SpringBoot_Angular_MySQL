import { ChildMenu } from "./ChildMenu";

export interface ParentMenu {
  idMenu: number;
  name: string;
  listChild: ChildMenu[];
}