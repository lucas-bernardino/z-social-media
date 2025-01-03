import SplitedContainer from "../splited-container";

import { MessageCircle, Repeat2, Heart, BarChart2 } from "lucide-react";
import ProfileCard from "./profile-card/indes";

export default function Tweet() {

  const profile = {
    name: "Lucas Bernardino",
  }

  return (
    <SplitedContainer>
      <div className="flex flex-col w-full gap-2">
        <div>
          <span>
            <ProfileCard />
          </span>
          <span className="font-light px-2">8m</span>
        </div>
        <div>
          Tweet content!
        </div>

        <div className="flex w-full justify-between">

          <div className="flex gap-2 w-max items-center">
            <Heart />
            <span className="font-light">0</span>
          </div>

          <div className="flex gap-2 w-max items-center">
            <MessageCircle />
            <span className="font-light">0</span>
          </div>

          <div className="flex gap-2 w-max items-center">
            <Repeat2 />
            <span className="font-light">0</span>
          </div>

        </div>

      </div>
    </SplitedContainer>
  )
}
